import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score

# Dataset
data = pd.DataFrame({
    'Age': [45,54,60,48,52,46],
    'Sex': [1,0,1,0,1,0],
    'ChestPain': [3,2,1,2,3,1],
    'BP': [130,140,120,135,150,128],
    'Cholesterol': [230,250,240,220,260,210],
    'MaxHR': [150,140,130,160,120,170],
    'Target': [1,1,0,1,0,1]
})

# Features & Target
X = data.drop('Target', axis=1)
y = data['Target']

# Split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Model
model = LogisticRegression()
model.fit(X_train, y_train)

# Prediction
y_pred = model.predict(X_test)

# Output
print("Predicted:", y_pred)
print("Actual:", y_test.values)
print("Accuracy:", accuracy_score(y_test, y_pred))