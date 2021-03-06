const recognitionImageInputElement = document.querySelector(
    '#recognition-image-input',
);
const recognitionConfidenceInputElement = document.querySelector(
    '#recognition-confidence-input',
);
const recognitionProgressElement = document.querySelector('#recognition-progress');
const recognitionTextElement = document.querySelector('#recognition-text');
const originalImageElement = document.querySelector('#original-image');
const labeledImageElement = document.querySelector('#labeled-image');
recognitionImageElement.addEventListener('change', () => {
    if (!recognitionImageElement.files) {
        return null;
    }
    const file = recognitionImageElement.files[0];
    return tesseract
        .recognize(file, {
            lang: 'eng',
        })
        .progress(({ progress, status }) => {
            if (!progress || !status || status !== 'recognizing text') {
                return null;
            }
            const p = (progress * 100).toFixed(2);
            recognitionProgressElement.textContent = `${status}: ${p}%`;
            recognitionProgressElement.value = p;
        })
})
