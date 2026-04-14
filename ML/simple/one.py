# import numpy as np

# # Data
# x = np.array([1, 2, 3, 4, 5])
# y = np.array([2, 4, 5, 4, 5])

# # Calculate coefficients
# m = np.sum((x - x.mean()) * (y - y.mean())) / np.sum((x - x.mean())**2)
# b = y.mean() - m * x.mean()

# print("Slope (m):", m)
# print("Intercept (b):", b)

# # Prediction
# x_new = 6
# y_pred = m * x_new + b
# print("Prediction for x=6:", y_pred)

import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
np.random.seed(42)
X = 2 * np.random.rand(100, 1)
Y = 4 + 3 * X + np.random.randn(100, 1)
X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.2, random_state=42)
model = LinearRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
print(f"Intercept (b): {model.intercept_[0]}")
print(f"Slope (m): {model.coef_[0][0]}")
plt.scatter(X_test, y_test, color="blue", label="Actual Data")
plt.plot(X_test, y_pred, color="red", linewidth=2, label="Regression Line")
plt.xlabel("X")
plt.ylabel("Y")
plt.legend()
plt.title("Simple Linear Regression")
plt.show()
