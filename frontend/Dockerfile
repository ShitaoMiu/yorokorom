# 첫 번째 스테이지: 애플리케이션 빌드
FROM node:14 as builder

# 작업 디렉토리 설정
WORKDIR /app

# package.json 복사 및 의존성 설치
COPY package.json .
RUN npm install

# 현재 디렉토리의 모든 파일 복사
COPY . .

# 애플리케이션 빌드
RUN npm run build

# 두 번째 스테이지: Nginx 설정
FROM nginx:latest

# Nginx 설정 파일 복사
COPY nginx.conf /etc/nginx/conf.d/default.conf

# 첫 번째 스테이지에서 빌드한 애플리케이션을 Nginx의 웹 루트로 복사
COPY --from=builder /app/build /usr/share/nginx/html

# 80 포트 노출
EXPOSE 80

# Nginx 실행
CMD ["nginx", "-g", "daemon off;"]
