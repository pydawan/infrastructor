package io.infrastructor.core.provisioning.actions

import javax.validation.constraints.NotNull

import static io.infrastructor.core.inventory.CommandBuilder.CMD

class GroupAction {
    
    @NotNull
    def name
    def gid
    def user
    def sudopass

    def execute(def node) {
        def cmd = CMD {
            add sudopass, "echo $sudopass |"
            add sudopass || user, "sudo -S"
            add user, "-u $user"
            add "groupadd"
            add gid, "-g $gid"
            add name
        }
        
        node.execute command: cmd
        node.lastResult
    }
}
