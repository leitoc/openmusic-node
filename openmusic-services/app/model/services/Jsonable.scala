/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic-services - services
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

package model.services

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import org.json4s.jackson.JsonMethods._
import model.metadata._
import model.playlist._

trait Jsonable {
  
	/*
	 * Esto no es feliz :(
	 */
	implicit def formats = DefaultFormats + FieldSerializer[Metadata]() + FieldSerializer[Playlist]()
	
	def toJson(obj: Object) = (write(obj))

}