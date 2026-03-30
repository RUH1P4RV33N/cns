# import pandas as pd
# import matplotlib.pyplot as plt

# # Create data
# data = {'Name': ['A', 'B', 'C', 'D'],
#         'Marks': [70, 85, 90, 60]}

# df = pd.DataFrame(data)

# # Pandas operations
# print("Data:\n", df)
# print("Average Marks:", df['Marks'].mean())

# # Matplotlib plot
# plt.bar(df['Name'], df['Marks'])
# plt.xlabel("Students")
# plt.ylabel("Marks")
# plt.title("Student Marks")
# plt.show()

import matplotlib.pyplot as plot
K_1=[8,4,6,3,5,10,13,16,12,21]
R_1=[11,6,13,15,17,5,3,2,8,19]
K_2=[6,9,18,14,16,15,11,16,12,20]
R_2=[16,4,10,13,18,20,6,2,17,15]
plot.scatter(K_1,R_1,c="Black",linewidths=2,marker="s",edgecolor="Brown",s=42)
plot.scatter(K_2,R_2,c="Purple",linewidths=2,marker="^",edgecolor="Grey",s=42)
plot.xlabel("X-axis")
plot.ylabel("Y-axis")
print("Scatter Plot")
plot.show()

import matplotlib.pyplot as plot
import numpy as nup
K=nup.linspace(2,4,8)
R=nup.linspace(5,7,9)
Q=nup.linspace(0,1,3)
plot.plot(K,K,label='K')
plot.plot(R,R,label='R')
plot.plot(Q,Q,label='Q')
plot.legend()
plot.show()


import pandas as pad
data={"contries":["a","b","c"],
 "capital":["x","y","z"],
 "currency":[1,2,3]}
data_table=pad.DataFrame(data)
print(data_table)
# OUTPUT:
#  contries capital currency
# 0 a x 1
# 1 b y 2
# 2 c z 3