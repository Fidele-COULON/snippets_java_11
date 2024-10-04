package fr.fidtec.mocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class MockSpyTest {

	// https://stackoverflow.com/questions/16467685/difference-between-mock-and-injectmocks
	@Mock
    Player player;
 
	// We will also get same behaviour using @Spy annotation. Even if the attribute name is different.
	// That's because Mockito will check the Type Signature of Game class, which is Player and List<String>. 
	@Spy List<String> enemies = new ArrayList<>();
	
	@InjectMocks
    GameSpy gameSpy;

    @Test
    void attackWithSwordTest() {
        
    	enemies.add("Dragon");
        enemies.add("Orc");
        
        Assertions.assertEquals(2, gameSpy.numberOfEnemies());
        
    }
	    
}
