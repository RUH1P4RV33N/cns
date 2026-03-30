# from sklearn.cluster import KMeans
# import numpy as np

# # Data
# X = np.array([[1, 2], [1, 4], [1, 0],
#               [10, 2], [10, 4], [10, 0]])

# # Model
# kmeans = KMeans(n_clusters=2)
# kmeans.fit(X)

# # Results
# print("Centroids:", kmeans.cluster_centers_)
# print("Labels:", kmeans.labels_)

import numpy as np
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
x1 = np.array([[1, 1], [1.5, 2], [3, 4], [5, 7], [3.5, 5], [4.5, 5], [3.5, 4]])
kmeans1 = KMeans(n_clusters=2, random_state=0).fit(x1)
x2 = np.random.rand(20, 2) * 10 # 20 points between 0 and 10
kmeans2 = KMeans(n_clusters=3, random_state=1).fit(x2)
plt.figure(figsize=(10, 4))
plt.subplot(1, 2, 1)
plt.scatter(x1[:, 0], x1[:, 1], c=kmeans1.labels_, cmap='viridis', s=100)
plt.scatter(kmeans1.cluster_centers_[:, 0], kmeans1.cluster_centers_[:, 1], c='black', marker='x', s=200, linewidths=3)
plt.title("KMeans on Dataset 1")
# Second plot
plt.subplot(1, 2, 2)
plt.scatter(x2[:, 0], x2[:, 1], c=kmeans2.labels_, cmap='plasma', s=100)
plt.scatter(kmeans2.cluster_centers_[:, 0], kmeans2.cluster_centers_[:, 1], c='black', marker='x', s=200, linewidths=3)
plt.title("KMeans on Dataset 2")
plt.tight_layout()
plt.show()