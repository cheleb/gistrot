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
  private def repoAsOption[P](f: Ptr[git_buf] => CInt)(implicit
      z: Zone
  ): Option[Ptr[git_buf]] =
    val repoRef = alloc[git_buf](1)
    if f(repoRef) == 0 then Some(repoRef)
    else None

  def repo(path: CString)(implicit z: Zone): Option[Repo] =
    for {
      path <- repoAsOption(git_repository_discover(_, c".", 1, c""))
      repo <- asOption(git_repository_open(_, (!path).ptr))
      head <- asOption(git_repository_head(_, !repo))
      upstream = asOption(git_branch_upstream(_, !head))
    } yield Repo(!repo, !head, upstream.map(!_))
