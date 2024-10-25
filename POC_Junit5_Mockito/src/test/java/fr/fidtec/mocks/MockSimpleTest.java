package fr.fidtec.mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// https://stackoverflow.com/questions/55792535/how-to-fix-mockitoextension-class-not-resolved-error
@ExtendWith(MockitoExtension.class)
class MockSimpleTest {

	/* https://stackoverflow.com/questions/16467685/difference-between-mock-and-injectmocks
	 * 
	 * @Mock annotation mocks the concerned object.
	 * 
	 * @InjectMocks annotation allows to inject into the underlying object the different (and relevant) mocks created by @Mock.
	 */
	@Mock
    Player player;
 
	/* sans InjectMocks
	 java.lang.NullPointerException: Cannot invoke "fr.fidtec.mocks.Game.attack()" because "this.game" is null
	 	at fr.fidtec.mocks.MockTest.attackWithSwordTest(MockTest.java:27)
		at java.base/java.lang.reflect.Method.invoke(Method.java:568)
		at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
		at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	*/
	
	/* avec InjectMocks
	 you don't have to do this
	 	Game game = new Game(player);
	*/

	@InjectMocks
    GameSimple gameSimple;

    @Test
    void attackWithSwordTest() {
        
    	Mockito.when(player.getWeapon()).thenReturn("Sword");

    	Assertions.assertEquals("Player attack with: Sword", gameSimple.attack());
    }
	    
}
