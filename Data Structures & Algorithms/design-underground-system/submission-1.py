from collections import defaultdict

class UndergroundSystem:
    def __init__(self):
        self.stationToDuration = defaultdict(lambda: [0,0]) ## Key is (startStation, endStation), value is list of times
        self.idToStartStationTime = defaultdict(tuple)

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.idToStartStationTime[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        ## When this takes in id, we should be able to see correspondig startStation and time
        startStation, startTime = self.idToStartStationTime[id]
        route = self.stationToDuration[(startStation, stationName)]
        route[0] += (t - startTime)
        route[1] += 1 

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        durations = self.stationToDuration[(startStation, endStation)]
        return durations[0] / durations[1]
