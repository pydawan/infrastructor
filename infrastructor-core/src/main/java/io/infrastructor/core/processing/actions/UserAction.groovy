package io.infrastructor.core.processing.actions

import javax.validation.constraints.NotNull

import static io.infrastructor.core.inventory.CommandBuilder.CMD

public class UserAction {
    
    @NotNull
    def name
    def uid
    def shell
    def home
    def sudo = false

    def execute(def node) {
        node.execute command: CMD {
            add sudo, "sudo"
            add "useradd"
            add uid,   "-u $uid"
            add shell, "-s $shell"
            add home,  "-m -d $home"
            add name
        }
        
        node.lastResult
    }
}
