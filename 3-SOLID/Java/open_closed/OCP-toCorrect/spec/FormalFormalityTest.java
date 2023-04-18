public class FormalFormalityTest {
    @Test
    public void testSaysHelloFormally() {
        FormalFormality formality = new FormalFormality();
        assertEquals("Good evening, sir.", formality.salute());
    }

}
