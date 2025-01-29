public class insercao {
    public void insercao(int a[]) {
        int i, j, aux;
        int size = a.length;
        for (i = 1; i < size; i++) {
            aux = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > a[j + 1]){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = aux;
        }
    }
}