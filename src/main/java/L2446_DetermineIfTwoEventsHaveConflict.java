public class L2446_DetermineIfTwoEventsHaveConflict {

    /*
        2446. Determine if Two Events Have Conflict

        https://leetcode.com/problems/determine-if-two-events-have-conflict/

        You are given two arrays of strings that represent two inclusive events that happened on the same day,
        event1 and event2, where:

        event1 = [startTime1, endTime1] and
        event2 = [startTime2, endTime2].
        Event times are valid 24 hours format in the form of HH:MM.

        A conflict happens when two events have some non-empty intersection (i.e., some moment is common to
        both events).
        Return true if there is a conflict between two events. Otherwise, return false.

        Example 1:
        Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
        Output: true
        Explanation: The two events intersect at time 2:00.

        Example 2:
        Input: event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
        Output: true
        Explanation: The two events intersect starting from 01:20 to 02:00.

        Example 3:
        Input: event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
        Output: false
        Explanation: The two events do not intersect.

        Example 4:
        event1 = ["14:13","22:08"]
        event2 = ["02:40","08:08"]
        Output: false

        Constraints:
        evnet1.length == event2.length == 2.
        event1[i].length == event2[i].length == 5
        startTime1 <= endTime1
        startTime2 <= endTime2
        All the event times follow the HH:MM format.
     */

    public boolean haveConflict(String[] event1, String[] event2) {
        int event1StartHours = Integer.parseInt(event1[0].substring(0,2));
        int event1StartMinutes = Integer.parseInt(event1[0].substring(3));

        int event1FinishHours = Integer.parseInt(event1[1].substring(0,2));
        int event1FinishMinutes = Integer.parseInt(event1[1].substring(3));

        int event2StartHours = Integer.parseInt(event2[0].substring(0,2));
        int event2StartMinutes = Integer.parseInt(event2[0].substring(3));

        int event2FinishHours = Integer.parseInt(event1[1].substring(0,2));
        int event2FinishMinutes = Integer.parseInt(event1[1].substring(3));

        if (event2StartHours <= event1FinishHours && event1StartHours <= event2FinishHours) {
            return true;
        }
//        } else if (event1FinishHours == event2StartHours && event1FinishMinutes > event2StartMinutes) {
//            return true;
//        } else if (event2StartHours == event1FinishHours) {
//            return true;
//        } else if (event2FinishHours == event1StartHours && event2FinishMinutes < event1StartMinutes) {
//            return true;
//        }

        return false;
    }

    public boolean haveConflict1(String[] event1, String[] event2){
        int st1 = Integer.parseInt(event1[0].substring(0, 2))*60 + Integer.parseInt(event1[0].substring(3));
        int et1 = Integer.parseInt(event1[1].substring(0, 2))*60 + Integer.parseInt(event1[1].substring(3));
        int st2 = Integer.parseInt(event2[0].substring(0, 2))*60 + Integer.parseInt(event2[0].substring(3));
        int et2 = Integer.parseInt(event2[1].substring(0, 2))*60 + Integer.parseInt(event2[1].substring(3));
        return st2<=et1 && st1<=et2;
    }
}
