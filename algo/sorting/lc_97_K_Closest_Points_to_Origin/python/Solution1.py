class Solution1:

    def kCloest(self, points: List[List[int]], k: int) -> List[List[int]]:
        points.sort(key = self.square_distance)
        return points[:k]

    def square_distance(self, point: List[int]) -> int:
        return point[0]**2 + point[1]**2