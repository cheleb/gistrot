package libgit2

import libgit.functions.*
import libgit.types.*
import scala.scalanative.unsafe.*

/** Scala friendly wrappers
  */

object LibGit2:
  private def asOption[P](f: Ptr[Ptr[P]] => CInt)(implicit
      z: Zone
  ): Option[Ptr[Ptr[P]]] =
    val repoRef = alloc[Ptr[P]](1)
    if f(repoRef) == 0 then Some(repoRef)
    else None

  def repo(path: CString)(implicit z: Zone): Option[Repo] =
    for {
      repo <- asOption(git_repository_open(_, c"."))
      head <- asOption(git_repository_head(_, !repo))
      upstream = asOption(git_branch_upstream(_, !head))
    } yield Repo(!repo, !head, upstream.map(!_))
