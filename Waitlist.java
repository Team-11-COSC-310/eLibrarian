import java.util.*;
/* This is going make a book's waitlist OF USERS,
and COUNT how many users are on it
*/

// Make waitlist of users
public class WaitList {
    //make empty list
    private ArrayList<User> wList = new ArrayList<User>();

    //fill the list with users
    public WaitList(ArrayList<User> wList) {
        this.wList.addAll(wList);
    }
    //
    public WaitList() {
        this(new ArrayList<User>());
    }

    //add user to list
    public boolean AddUser(User User) {
        if(User != null && !User.equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        wList.add(User); //only add info IF NOT EMPTY
       return true;
    }

    //waitlist counter and wait time calculator
    public wl_count() {
        int num = 0;
        for (int i=0; i<WaitList.size(); i++) {
            num += 1; //for every user on list, add 1 to count
        }
        int wtime = num * 21; //waittime for the book is the number of people waiting * 21 days
        return num, wtime; //return count of users + wait time
    }

    
}
