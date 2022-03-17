package libgit2

import libgit.functions.*
import libgit.types.*
import scala.scalanative.unsafe.*

/** Scala friendly wrappers
  */

object LibGit2:
  def zozo[P](p: P)(f: P => CInt): Option[P] =
    if f(p) == 0 then Some(p)
    else None

  def repo(path: CString)(implicit z: Zone): Option[Repo] =
    val repoRef = alloc[Ptr[git_repository]](1)
    val headRef = alloc[Ptr[git_reference]](1)
    val upstreamRef = alloc[Ptr[git_reference]](1)

    for {
      repo <- zozo(repoRef)(git_repository_open(_, c"."))
      head <- zozo(headRef)(git_repository_head(_, !repoRef))
      upstream = zozo(upstreamRef)(git_branch_upstream(_, !headRef))
    } yield Repo(!repoRef, !head, upstream.map(!_))
