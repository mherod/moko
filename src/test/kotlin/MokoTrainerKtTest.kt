import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MokoTrainerKtTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testRoot() {

        val root = MokoTrainer().root
        assertEquals(root, root.train().root)
        assertEquals(root, root.train().root.train().root)
        assertEquals(root, root.train().root.root)
        assertEquals(root, root.train().root.root.root)
    }

    @Test
    fun testTestTest() {

        val adb = MokoTrainer()
                .train("adb devices", "device123")
                .train("adb -s device123 shell", "opened shell")

        assertEquals(
                "device123",
                adb.ride("adb devices").output
        )

        assertEquals(
                "opened shell",
                adb.ride("adb -s device123 shell").output
        )

        assertEquals(
                "adb devices\n\nadb -s device123 shell",
                adb.ride("adb -s device123 shell").previous
        )
    }
}