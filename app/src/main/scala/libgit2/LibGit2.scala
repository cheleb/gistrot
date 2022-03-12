package libgit2

import libgit.functions.*
import libgit.types.*
import scala.scalanative.unsafe.*

object LibGit2:
  def repo(path: CString)(implicit z: Zone): Repo =
    val repoRef: Ptr[Ptr[git_repository]] = alloc[Ptr[git_repository]](1)
    val res = git_repository_open(repoRef, c".")
    Repo(repoRef)
