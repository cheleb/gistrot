import libgit.functions.*
import libgit.types.*

import scala.scalanative.unsafe.*
import scala.scalanative.libc.*
import libgit.predef

import scala.scalanative.unsigned.*

import libgit2.*
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

@main def gistrotPrompt =
  Zone { implicit z =>
    git_libgit2_init()

    LibGit2.repo(c".").foreach { repo =>

      repo.diffs().foreach { case (st, count) =>
        print(s"$st $count ")
      }
      val branchName = repo.branchName

      repo.upstream match {
        case Some(upstream) =>
          for {
            upstream <- repo.upstreamName
            (ahead, behind) <- repo.upstreamStatus
          } yield
            if ahead > 0 then print(s"⬆️ +$ahead ")
            print(branchName)
            upstream match {
              case s"origin/$branchName" =>
              case _                     => print(s" ($upstream)")
            }
            if behind > 0 then print(s" ⬇️ +$behind")
        case None =>
          print(s" $branchName ❓")
      }

    }

    git_libgit2_shutdown()
  }
