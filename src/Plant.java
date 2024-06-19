public abstract class Plant {
    // Two instance variables that every type of plant would use Age and Height
    private int age = 0;
    private int height = 0;
    public void setHeight(int height)
    {
        this.height = height;
    }
    public int getAge()
    {
        return age;
    }
    public int getHeight()
    {
        return height;
    }
    public void addYearToAge()
    {
        age++;
    }
    /** Each abstract method represents the actions that a plant must take during the specified season.
     * These actions are specific to the type of plant, therefore cannot be generalized*/
// Any class extends the Plant class must implement these abstract methods.
    abstract public void doSpring();
    abstract public void doSummer();
    abstract public void doFall();
    abstract public void doWinter();

}
