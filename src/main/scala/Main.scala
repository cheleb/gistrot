import libgit.functions.*
import libgit.types.*

import scala.scalanative.unsafe.*
import scala.scalanative.libc.*
import libgit.predef

import scala.scalanative.unsigned.*

import gistrot.*

@main def gistrotPrompt =
  Zone { implicit z =>
    git_libgit2_init()
    val repoRef: Ptr[Ptr[git_repository]] = alloc[Ptr[git_repository]](1)
    val res = git_repository_open(
      repoRef,
      c"."
    )
    val head = alloc[Ptr[git_reference]](1)

    val error = git_repository_head(head, !repoRef)

    if (error == 0) {
      val branch = git_reference_shorthand(!head)
      stdio.printf(c"%s ", branch)
    }

    diffs(repoRef).foreach { case (st, count) =>
      print(s"$st $count ")
    }

    git_libgit2_shutdown()
  }
