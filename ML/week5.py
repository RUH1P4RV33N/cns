# import pandas as pd
# from sklearn.model_selection import train_test_split
# from sklearn.linear_model import LinearRegression

# # Dataset
# data = {
#     'Area': [1000, 1500, 2000, 2500, 3000],
#     'Bedrooms': [2, 3, 3, 4, 4],
#     'Age': [10, 5, 3, 2, 1],
#     'Price': [300000, 400000, 500000, 600000, 650000]
# }

# df = pd.DataFrame(data)

# # Features & Target
# X = df[['Area', 'Bedrooms', 'Age']]
# y = df['Price']

# # Split data
# X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)

# # Model
# model = LinearRegression()
# model.fit(X_train, y_train)

# # Prediction
# pred = model.predict(X_test)

# print("Predicted Prices:", pred)

import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_absolute_error, mean_squared_error
data = pd.DataFrame({
 'Area': [1200, 1500, 800, 2000, 1000],
 'Bedrooms': [3, 4, 2, 5, 2],
 'Bathrooms': [2, 3, 1, 4, 1],
 'Location': ['Downtown', 'Suburb', 'Downtown', 'Suburb', 'Uptown'],
 'Price': [300000, 400000, 200000, 500000, 250000]
})
data = pd.get_dummies(data, columns=['Location'], drop_first=True)
x = data.drop('Price', axis=1)
y = data['Price']
print("Features (X):")
print(x)
print("\nTarget (Y):")
print(y)
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state=42)
model = LinearRegression().fit(x_train, y_train)
y_pred = model.predict(x_test)
print("\nMean Squared Error:", mean_squared_error(y_test, y_pred))
print("Mean Absolute Error:", mean_absolute_error(y_test, y_pred))
print("\nPredicted Prices:", y_pred)
print("Actual Prices:", y_test.values)
# OUTPUT:
# Features (X):
#  Area Bedrooms Bathrooms Location_Suburb Location_Uptown
# 0 1200 3 2 False False
# 1 1500 4 3 True False
# 2 800 2 1 False False
# 3 2000 5 4 True False
# 4 1000 2 1 False True
# Target (Y):
# 0 300000
# 1 400000
# 2 200000
# 3 500000
# 4 250000
# Name: Price, dtype: int64
# Mean Squared Error: 624989583.4635327
# Mean Absolute Error: 24999.791668402613
# Predicted Prices: [375000.2083316]
# Actual Prices: [400000]