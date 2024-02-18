/**
 * Problem: Meeting Rooms III
 * Description: You are given an integer n. There are n rooms numbered from 0 to n - 1.
 *
 * You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.
 *
 * Meetings are allocated to rooms in the following manner:
 *
 * Each meeting will take place in the unused room with the lowest number.
 * If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
 * When a room becomes unused, meetings that have an earlier original start time should be given the room.
 * Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.
 *
 * A half-closed interval [a, b) is the interval between a and b including a and not including b.
 */
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] roomsUsedCount = new int[n];
        long[] lastAvailableAt = new long[n];

        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];
            boolean found = false;

            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;

            for (int room = 0; room < n; room++) {
                if (lastAvailableAt[room] <= start) {
                    found = true;
                    lastAvailableAt[room] = end;
                    roomsUsedCount[room]++;
                    break;
                }

                if (lastAvailableAt[room] < earlyEndRoomTime) {
                    earlyEndRoom = room;
                    earlyEndRoomTime = lastAvailableAt[room];
                }
            }

            if (!found) {
                lastAvailableAt[earlyEndRoom] += (end - start);
                roomsUsedCount[earlyEndRoom]++;
            }
        }

        int resultRoom = -1;
        int maxUse = 0;
        for (int room = 0; room < n; room++) {
            if (roomsUsedCount[room] > maxUse) {
                maxUse = roomsUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}