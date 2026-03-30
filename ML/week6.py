# from sklearn.tree import DecisionTreeClassifier
# from sklearn.model_selection import train_test_split, GridSearchCV
# from sklearn.datasets import load_iris

# # Load dataset
# data = load_iris()
# X, y = data.data, data.target

# # Split
# X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)

# # Model
# model = DecisionTreeClassifier()

# # Parameter tuning
# params = {
#     'max_depth': [2, 3, 4, 5],
#     'criterion': ['gini', 'entropy']
# }

# grid = GridSearchCV(model, params, cv=5)
# grid.fit(X_train, y_train)

# # Best model
# best_model = grid.best_estimator_

# # Accuracy
# accuracy = best_model.score(X_test, y_test)

# print("Best Parameters:", grid.best_params_)
# print("Accuracy:", accuracy)

from sklearn.datasets import fetch_california_housing
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt
data = fetch_california_housing()
X = data.data
y = data.target
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
model = LinearRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
print("Coefficients:", model.coef_)
print("Intercept:", model.intercept_)
plt.plot(y_pred[:50], label='Predicted', color='blue')
plt.plot(y_test[:50].values if hasattr(y_test, 'values') else y_test[:50], label='Actual', color='red')
plt.title("California Housing Price Prediction")
plt.legend()
plt.show()
# OUTPUT:
# Coefficients: [ 4.38565392e-01 9.68722037e-03 -1.04705005e-01 6.321894
# -3.67690711e-06 -3.44771323e-03 -4.25964056e-01 -4.40601114e-01]
# Intercept: -37.515754159836554