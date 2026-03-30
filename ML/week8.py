# from sklearn.linear_model import LogisticRegression
# from sklearn.model_selection import train_test_split
# from sklearn.datasets import load_iris

# # Load dataset
# data = load_iris()
# X, y = data.data, data.target

# # Convert to binary classification (optional for simplicity)
# y = (y == 0)

# # Split data
# X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)

# # Model
# model = LogisticRegression()
# model.fit(X_train, y_train)

# # Prediction
# pred = model.predict(X_test)

# # Accuracy
# print("Accuracy:", model.score(X_test, y_test))

from sklearn.datasets import load_diabetes
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
import numpy as np
data = load_diabetes()
X = data.data
y = data.target
y_binary = np.where(y > np.median(y), 1, 0)
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)
x_train, x_test, y_train, y_test = train_test_split(X_scaled, y_binary, test_size=0.2,random_state=42)
model = LogisticRegression(max_iter=200).fit(x_train, y_train)
y_pred = model.predict(x_test)
print("Accuracy: {:.2f}%".format(accuracy_score(y_test, y_pred) * 100))
print("Confusion Matrix:\n", confusion_matrix(y_test, y_pred))
print("Classification Report:\n", classification_report(y_test, y_pred))