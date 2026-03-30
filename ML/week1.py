# import statistics as s

# data = list(map(int, input("Enter numbers: ").split()))

# # Central Tendency
# mean = s.mean(data)
# median = s.median(data)
# mode = s.mode(data)

# # Dispersion
# variance = s.variance(data)
# std_dev = s.stdev(data)

# print("Mean:", mean)
# print("Median:", median)
# print("Mode:", mode)
# print("Variance:", variance)
# print("Standard Deviation:", std_dev)

import statistics as stats
data = [2, 4, 4, 6, 8, 10, 12, 14, 16, 18]
mean = stats.mean(data)
median = stats.median(data)
mode = stats.mode(data)
variance = stats.variance(data)
std_deviation = stats.stdev(data)
print("Mean:", mean)
print("Median:", median)
print("Mode:", mode)
print("Variance:", variance)
print("Standard Deviation:", std_deviation)
# OUTPUT:
# Mean: 9.4
# Median: 9.0
# Mode: 4
# Variance: 30.266666666666666
# Standard Deviation: 5.501514942874069