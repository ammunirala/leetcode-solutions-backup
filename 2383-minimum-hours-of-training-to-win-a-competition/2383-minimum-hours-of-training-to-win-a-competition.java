class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int hours = 0;
        int totalEnergyNeeded = 0;
        for (int e : energy) {
            totalEnergyNeeded += e;
        }

        if (initialEnergy <= totalEnergyNeeded) {
            hours += (totalEnergyNeeded + 1 - initialEnergy);
        }

    
        int currExp = initialExperience;
        for (int i = 0; i < experience.length; i++) {
            if (currExp <= experience[i]) {
                int need = experience[i] + 1 - currExp;
                hours += need;
                currExp += need;
            }
            currExp += experience[i];
        }

        return hours;
    }
}
