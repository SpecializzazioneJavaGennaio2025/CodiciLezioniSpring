package it.aulab;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("it.aulab")
public class AppConfig {
    // @Scope("prototype")
    //@Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean(name="jeeg")
    public Jeeg getJeeg() {
        return new Jeeg(getArmSx(), getArmDx(), getLegSx(), getLegDx());
    }

    @Bean(name="armSx")
    public Arm getArmSx() {
        return new Arm(Side.Sx);
    }

    @Bean(name="armDx")
    public Arm getArmDx() {
        return new Arm(Side.Dx);    
    }

    @Bean(name="legSx")
    public Leg getLegSx() {
        return new Leg(Side.Sx);
    }

    @Bean(name="legDx")
    public Leg getLegDx() {
        return new Leg(Side.Dx);
    }
}
