public class Rose extends Plant{
    private static final int AMOUNT_TO_GROW_IN_ONE_GROWING_SEASON = 1; //will grow to a height of 1 every season
    private void grow()
    {
        int currentHeight = getHeight();
        setHeight(currentHeight + AMOUNT_TO_GROW_IN_ONE_GROWING_SEASON);
    }
    private void dieDownForWinter()
    {
        setHeight(0);
    }
    //overriding the methods from Plant to do what I need it to do in Rose instead
//These methods are similar to the Tulip methods as they are both flowers
    @Override
    public void doSpring()
    {
        grow();
        addYearToAge();
        System.out.println("Spring: The rose is starting to grow up from the ground");
        System.out.println("\tCurrent Age: " + getAge() + " " + "Current Height: " + getHeight());
    }
    @Override
    public void doSummer()
    {
        System.out.println("Summer: The rose has stopped to growing and is flowering");
        System.out.println("\tCurrent Age: " + getAge() + " " + "Current Height: " + getHeight());
    }
    @Override
    public void doFall()
    {
        System.out.println("Fall: The rose begins to wilt");
        System.out.println("\tCurrent Age: " + getAge() + " " + "Current Height: " + getHeight());
    }
    @Override
    public void doWinter()
    {
        dieDownForWinter();
        System.out.println("Winter: The rose is dormant.");
        System.out.println("\tCurrent Age: " + getAge() + " " + "Current Height: " + getHeight());
    }

}
