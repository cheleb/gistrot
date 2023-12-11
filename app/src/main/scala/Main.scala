import fansi.*
import fansi.Color.*
import libgit.functions.*
import libgit.types.*

import scala.scalanative.unsafe.*
import scala.scalanative.libc.*
import libgit.predef

import scala.scalanative.unsigned.*

import libgit2.*
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

@main def gistrotPrompt(spaces: Int, fill: String) =
  val pwd =
    if (os.pwd.startsWith(os.home)) then
      s"~/${os.pwd.relativeTo(os.home).toString}"
    else os.pwd.toString

  Zone { implicit z =>
    git_libgit2_init()

    LibGit2.repo(c".").map { repo =>

      val diffs = repo
        .diffs()
        .map { case (st, count) =>
          s"$st $count"
        }
        .mkString(" ")
      val branchName = repo.branchName

      val branch = "\uE0A0" + (repo.upstream match {
        case Some(upstream) =>
          val branch = for {
            upstream <- repo.upstreamName
            (ahead, behind) <- repo.upstreamStatus
          } yield
            val toPush =
              if ahead > 0 then s"⬆️ +$ahead "
              else ""
            val up = upstream match {
              case s"origin/$branchName" => ""
              case _                     => s" ($upstream)"
            }
            val toPull =
              if behind > 0 then s" ⬇️ +$behind"
              else ""
            s"$toPush $branchName$up$toPull"
          branch.getOrElse(s"$branchName 💀")
        case None =>
          s"$branchName ❓"
      })
      val right = s" $diffs"
      val path = Reversed.On(
        Bold.On(
          Blue(Back.White(pwd + " ")) ++ Green(Back.Blue("\uE0C0 ")) ++
            Green(" " + branch) ++ Black(Back.Green("\uE0C0 "))
        )
      )

      s"$path${fill * (spaces - path.length - right.length)}$right"

    } match
      case None        => println(pwd)
      case Some(value) => println(value)
    println()

    git_libgit2_shutdown()
  }
