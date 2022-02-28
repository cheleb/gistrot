import libgit.functions.*
import libgit.types.*

import scala.scalanative.unsafe.*
import scala.scalanative.libc.*
import libgit.predef

import scala.scalanative.unsigned.*

import gistrot.*

@main def hello =
  Zone { implicit z =>
    git_libgit2_init()
    val repoRef: Ptr[Ptr[git_repository]] = alloc[Ptr[git_repository]](1)
    val res = git_repository_open(
      repoRef,
      c"."
    )

//    stdio.printf(c"Repo path: %s\n", git_repository_path(!repoRef))

    val head = alloc[Ptr[git_reference]](1)

    val error = git_repository_head(head, !repoRef)

    if (error == 0) {
      val branch = git_reference_shorthand(!head)
      stdio.printf(c"%s ", branch)
    }
    /*
    val it = alloc[Ptr[git_branch_iterator]](1)
    git_branch_iterator_new(it, !repoRef, git_branch_t.GIT_BRANCH_REMOTE)

    val gitref = alloc[Ptr[git_reference]](1)
    val branch_type = alloc[git_branch_t](1)
    val str = alloc[Ptr[CChar]](100)

    while git_branch_next(gitref, branch_type, !it) == 0 do
      git_branch_name(str, !gitref)

      stdio.printf(c"Branch: %s\n", !str)
     */
    diffs(repoRef).foreach { case (st, count) =>
      print(s"$st $count ")
    }

    git_libgit2_shutdown()
  }
