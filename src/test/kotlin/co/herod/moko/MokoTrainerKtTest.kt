package co.herod.moko

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MokoTrainerKtTest {

    private lateinit var adb: MokoTrainer

    @Before
    fun setUp() {

        adb = MokoTrainer()
                .t("adb devices")
                .t("adb help")
                .t("adb version")
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

        assertEquals(
                "List of devices attached\n\n",
                adb.ride("adb devices").output
        )

        assertEquals(
                "adb devices\n\nadb help\n\nadb version",
                adb.ride("adb version").previous
        )

        assertEquals(
                "adb devices\n\nadb help",
                adb.ride("adb help").previous
        )
    }
}

