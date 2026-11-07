class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
		boolean hasDeleted = true;

		while (hasDeleted) {
			hasDeleted = false;
			int count = 1;

			for (int i = 0; i < sb.length(); i++) {
				if (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) {
					count++;
				} else {
					count = 1;
				}

				if (count == k) {
					sb.delete(i - k + 1, i + 1);
					hasDeleted = true;
					break;
				}
			}
		}
		
		return sb.toString();
    }
}