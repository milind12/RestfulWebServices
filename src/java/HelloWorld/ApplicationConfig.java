/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Milind Ghiya
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(HelloWorld.AddContestService.class);
        resources.add(HelloWorld.ContestService.class);
        resources.add(HelloWorld.ContestUpdateService.class);
        resources.add(HelloWorld.DeleteContestService.class);
        resources.add(HelloWorld.Helloworld.class);
        resources.add(HelloWorld.LoginService.class);
        resources.add(HelloWorld.RegisterService.class);
        resources.add(HelloWorld.UpdateProfileService.class);

    }

}
