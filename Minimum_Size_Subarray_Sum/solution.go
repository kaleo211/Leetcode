package solution

func minSubArrayLen(s int, nums []int) int {
	length := len(nums)
	if length < 1 {
			return 0
	}

	start := 0
	end := 0
	min := int(^uint(0) >> 1)
	sum := nums[0]

	for end < length {
			if sum < s {
					if end == len(nums) -  1 {
							break;
					}
					end++
					sum += nums[end]
			} else {
					l := end - start + 1
					if l < min {
							min = l
					}
					sum -= nums[start]
					start++
			}
	}

	if min > len(nums) {
			return 0
	}
	return min
}
