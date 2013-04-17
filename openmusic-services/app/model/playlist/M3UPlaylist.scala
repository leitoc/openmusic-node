/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic-services - playlist
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*
*   Project: http://github.com/SideEffectIdeas/openmusic-node
*   Wiki: http://github.com/SideEffectIdeas/openmusic-node/wiki
*   Mailing list: http://groups.google.com/group/sideEffectIdeas
*/
package model.playlist

import java.io.File
import com.google.common.io.Files
import com.google.common.base.Charsets

trait M3UPlaylist {

  def toM3U = m3uElements.foldLeft("#EXTM3U")((b, a) => b + "\n" + a)

  def m3uElements: List[String];

  def retrieve: File = {
    var file = new File("/tmp/playlist.m3u")
    Files.write(this.toM3U, file, Charsets.UTF_8)
    file
  }

}