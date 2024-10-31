import matplotlib.pyplot as plt
from matplotlib.patches import Rectangle

# Set up the figure and axis
fig, ax = plt.subplots(figsize=(10, 7))

# Define business model sections and their properties
sections = {
    "고객 세분화": {"text": "전세 세입자, 집주인, 공인중개사", "pos": (0.1, 0.75), "color": "#FFDDC1"},
    "가치 제안": {"text": "안전한 거래, 사기 방지, 투명한 정보 제공", "pos": (0.1, 0.55), "color": "#FFC4C4"},
    "핵심 활동": {"text": "사기 탐지, 데이터 검증, 안전 결제 처리", "pos": (0.1, 0.35), "color": "#FFDDC1"},
    "핵심 자원": {"text": "AI 사기 탐지, 제휴, 데이터베이스", "pos": (0.1, 0.15), "color": "#FFC4C4"},
    "고객 관계": {"text": "신뢰 구축, 고객 지원", "pos": (0.55, 0.75), "color": "#C1FFD7"},
    "채널": {"text": "앱 스토어, 부동산 웹사이트", "pos": (0.55, 0.55), "color": "#C4FFC4"},
    "비용 구조": {"text": "AI 개발, 플랫폼 유지비", "pos": (0.55, 0.35), "color": "#C1FFD7"},
    "수익 구조": {"text": "구독료, 거래 수수료", "pos": (0.55, 0.15), "color": "#C4FFC4"}
}

# Draw the sections as rectangles with labels
for key, value in sections.items():
    ax.add_patch(Rectangle(value["pos"], 0.35, 0.15, color=value["color"], edgecolor="black"))
    ax.text(value["pos"][0] + 0.02, value["pos"][1] + 0.08, key, fontsize=12, weight='bold')
    ax.text(value["pos"][0] + 0.02, value["pos"][1] + 0.04, value["text"], fontsize=10)

# Adjust and display
ax.axis("off")
plt.title("비즈니스 모델 캔버스")
plt.show()
