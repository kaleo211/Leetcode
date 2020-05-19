package solution

// 12ms
func findOrder(numCourses int, prerequisites [][]int) []int {
	added := make(map[int]bool)
	result := []int{}
	prefixs := make(map[int]int)
	next := make(map[int][]int)
	var queue []int

	for _, pair := range prerequisites {
			next[pair[1]] = append(next[pair[1]], pair[0])
			prefixs[pair[0]]++
	}

	for j := 0; j < numCourses; j++ {
			if prefixs[j] == 0 {
					queue = append(queue, j)
			}
	}

	for len(queue) != 0 {
			cur := queue[0]
			queue = queue[1:]

			if (prefixs[cur] == 0 && !added[cur]) {
					queue = append(queue, next[cur]...)
					for _, val := range next[cur] {
							if prefixs[val] > 0 {
									prefixs[val]--
							}
					}
					added[cur] = true
					result = append(result, cur)
			}
	}

	if len(result) < numCourses {
			return []int{}
	}
	return result
}
