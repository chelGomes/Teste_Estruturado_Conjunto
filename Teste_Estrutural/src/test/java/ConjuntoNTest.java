import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ConjuntoNTest {
        // Define o conjunto N
        private final Set<Integer> N = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);


        @Test
        void testPertenceAoConjunto() {
            assertTrue(N.contains(4), "O número 4 deveria pertencer ao conjunto");
            assertFalse(N.contains(10), "O número 10 não deveria pertencer ao conjunto");
        }

        @Test
        void testOperacoesComConjunto() {
            Set<Integer> uniao = new HashSet<>(N);
            uniao.addAll(Set.of(10, 11, 12));
            assertEquals(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), uniao, "A união deveria conter os novos elementos");

            Set<Integer> intersecao = new HashSet<>(N);
            intersecao.retainAll(Set.of(3, 6, 9));
            assertEquals(Set.of(3, 6, 9), intersecao, "A interseção deveria conter apenas os elementos comuns");

            Set<Integer> diferenca = new HashSet<>(N);
            diferenca.removeAll(Set.of(2, 4, 6));
            assertEquals(Set.of(1, 3, 5, 7, 8, 9), diferenca, "A diferença deveria remover os elementos 2, 4 e 6");
        }

        @Test
        void testTamanhoDoConjunto() {
            assertEquals(9, N.size(), "O tamanho do conjunto deveria ser 9");
        }

        @Test
        void testSubconjunto() {
            assertTrue(N.containsAll(Set.of(3, 5, 7)), "O conjunto deveria conter {3, 5, 7}");
            assertFalse(N.containsAll(Set.of(0, 10)), "O conjunto não deveria conter {0, 10}");
        }

        @Test
        void testMinMax() {
            assertEquals(1, N.stream().min(Integer::compareTo).orElseThrow(), "O menor número deveria ser 1");
            assertEquals(9, N.stream().max(Integer::compareTo).orElseThrow(), "O maior número deveria ser 9");
        }

    @Test
    void testPertinencia() {
        assertTrue(N.contains(1), "O número 1 deveria pertencer ao conjunto");
        assertTrue(N.contains(2), "O número 2 não deveria pertencer ao conjunto");
        assertTrue(N.contains(3), "O número 3 não deveria pertencer ao conjunto");
        assertTrue(N.contains(7), "O número 7 não deveria pertencer ao conjunto");
        assertTrue(N.contains(8), "O número 8 não deveria pertencer ao conjunto");
    }

    @Test
    void testOrdenacaoComoString() {
        // Ordena e converte para String
        String resultado = N.stream() //Ordena os elementos
                .sorted() //Converte cada número para String.
                .map(String::valueOf) //Une os números em uma única String
                .collect(Collectors.joining(", ")); // Garante que a string gerada corresponde ao esperado.

        String esperado = "1, 2, 3, 4, 5, 6, 7, 8, 9";

        assertEquals(esperado, resultado, "O conjunto deveria estar ordenado corretamente");
    }

}


