# import statistics as s
# import math
# import numpy as np
# from scipy import stats

# data = [1, 2, 3, 4, 5]

# # Statistics
# print("Mean:", s.mean(data))
# print("Median:", s.median(data))
# print("Mode:", s.mode(data))

# # Math
# print("Square root of 16:", math.sqrt(16))
# print("Factorial of 5:", math.factorial(5))

# # NumPy
# arr = np.array(data)
# print("NumPy Mean:", np.mean(arr))
# print("NumPy Sum:", np.sum(arr))

# # SciPy
# print("Variance (SciPy):", stats.tvar(arr))
# print("Standard Deviation (SciPy):", stats.tstd(arr))

import math
import numpy as np
import scipy.stats as st
import statistics as stats

square_root = math.sqrt(16)
print("Square root of 16:", square_root)
data = [5, 10, 15, 20, 25]
mean = stats.mean(data)
print("Mean using statistics:", mean)
arr = np.array([1, 2, 3, 4, 5])
mean_numpy = np.mean(arr)
print("Mean using numpy:", mean_numpy)
z_score = st.zscore(data)
print("Z-score using scipy:", z_score)

# OUTPUT:
# Square root of 16: 4.0
# Mean using statistics: 15
# Mean using numpy: 3.0
# Z-score using scipy: [-1.41421356 -0.70710678 0. 0.70710678 1.41421356]