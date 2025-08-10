class BytesToString {
    public static String fromBytes(byte[] data) {
        return new String(data);
    }

    public static void main(String[] args) {
//         byte[] a = new byte[26];
//         for (int i = 0; i < 26; i++) {
//             a[i] = 'a';
//         }
        byte[] a = null;
        System.out.println(fromBytes(a));
    }
}
