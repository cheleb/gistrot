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
      val upstream = repo.upstream
      print(branchName)
      upstream match {
        case Some(s"origin/$branchName") =>
//          scribe.info("Yes, it's that simple!")
        case Some(other) => print(s" ($upstream)")
        case _           => print("❓")
      }

    }

    git_libgit2_shutdown()
  }
