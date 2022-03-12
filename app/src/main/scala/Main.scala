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

    val repo = LibGit2.repo(c".")

    repo.diffs().foreach { case (st, count) =>
      print(s"$st $count ")
    }

    print(repo.branchName)

    git_libgit2_shutdown()
  }
