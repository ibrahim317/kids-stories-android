import cv2
import numpy as np
from pathlib import Path

ROOT_DIR = Path(".")  # root folder (recursive)

# Rectangle coordinates (inclusive)
LEFT, RIGHT = 708, 743
TOP, BOTTOM = 708, 743

for img_path in ROOT_DIR.rglob("*.webp"):
    img = cv2.imread(str(img_path), cv2.IMREAD_COLOR)

    if img is None:
        print(f"Skipping unreadable file: {img_path}")
        continue

    mask = np.zeros(img.shape[:2], dtype=np.uint8)
    mask[TOP:BOTTOM + 1, LEFT:RIGHT + 1] = 255

    result = cv2.inpaint(
        img,
        mask,
        inpaintRadius=3,
        flags=cv2.INPAINT_TELEA
    )

    # overwrite in place (high quality)
    cv2.imwrite(
        str(img_path),
        result,
        [cv2.IMWRITE_WEBP_QUALITY, 100]
    )

print("Done. All WebP images processed recursively in place.")
