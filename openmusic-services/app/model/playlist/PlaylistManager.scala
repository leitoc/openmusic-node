/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic - services
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

import java.util.Date

object PlaylistManager {

  var playlists: List[Playlist] = List()

  def all = playlists

  def newPlaylist: Playlist = {
    var playlist = new Playlist
    this add playlist
    playlist id = new Date().getTime.toString
    playlist
  }

  def add(playlist: Playlist) = playlists = playlists :+ playlist

  def find(id: String) = playlists find { elem => elem.id == id }

}