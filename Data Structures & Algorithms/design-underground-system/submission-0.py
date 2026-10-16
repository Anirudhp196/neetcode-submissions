from collections import defaultdict

class UndergroundSystem:
    def __init__(self):
        self.stationToDuration = defaultdict(list) ## Key is (startStation, endStation), value is list of times
        self.idToStartStationTime = defaultdict(tuple)

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.idToStartStationTime[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        ## When this takes in id, we should be able to see correspondig startStation and time
        startStation, startTime = self.idToStartStationTime[id]
        self.stationToDuration[(startStation, stationName)].append(t - startTime)

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        durations = self.stationToDuration[(startStation, endStation)]
        sum = 0
        for time in durations:
            sum += time
        return sum / len(durations)
