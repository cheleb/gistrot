package libgit2

import libgit.functions.*
import libgit.types.*
import scala.scalanative.unsafe.*

/**
 * Scala friendly wrappers
*/

object LibGit2:
  def repo(path: CString)(implicit z: Zone): Option[Repo] =
    val repoRef: Ptr[Ptr[git_repository]] = alloc[Ptr[git_repository]](1)
    val res = git_repository_open(repoRef, c".")
    val head = alloc[Ptr[git_reference]](1)
    if git_repository_head(head, !repoRef) == 0 then Some(Repo(repoRef, head))
    else None
