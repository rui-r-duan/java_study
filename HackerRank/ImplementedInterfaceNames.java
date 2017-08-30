class ImplementedInterfaceNames {
    static void implementedInterfaceNames(Object o) {
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++) {
            System.out.println(theInterfaces[i].getName());
        }
    }
}
