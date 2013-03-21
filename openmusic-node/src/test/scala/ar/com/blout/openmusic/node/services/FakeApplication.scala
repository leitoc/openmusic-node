/*Copyright (c) 2013 -  SideEffectIdeas 
*
*	Module: test - openmusic - services
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

package ar.com.blout.openmusic.node.services

import ar.com.blout.openmusic.node.configuration.Configuration

/**
 * Mock for the main process. Simulates a running Node process, but can be used when offline.
 */

object FakeApplication {
  def run = {
    Configuration config "testConfiguration.properties" 
    //load folder
  }
}