package fr.fidtec.mappers;

import fr.fidtec.beans.UserBeanDest;
import fr.fidtec.beans.UserBeanSource;
import fr.fidtec.enums.MrMme_FR;
import fr.fidtec.enums.MrMme_US;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {

    @Test
    public void mapper_Test_Ok1(){
        UserBeanSource source = new UserBeanSource("Fidele", "COULON", MrMme_US.Sir);

        UserBeanDest dest = UserMapper.INSTANCE.userBeanSourceToUserBeanDest(source);

        System.out.println(dest);

        assertEquals("Fidele", dest.getPrenom());
        assertEquals("COULON", dest.getNom());
        assertEquals( MrMme_FR.Monsieur, dest.getGenre());
    }

    @Test
    public void mapper_Test_Ok2(){
        UserBeanSource source = new UserBeanSource();

        UserBeanDest dest = UserMapper.INSTANCE.userBeanSourceToUserBeanDest(source);

        System.out.println(dest);

        assertEquals("", dest.getPrenom());
        assertEquals("", dest.getNom());
    }
}
